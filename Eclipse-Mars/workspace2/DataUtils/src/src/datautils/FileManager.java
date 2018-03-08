package src.datautils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

public class FileManager {

	private File file;
	private ArrayList<ICodeSegment> codeSegments;
	private EnumEventPriority eventPriority;
	private final String DOWNLOAD;

	public FileManager(File file) {
		this.DOWNLOAD = System.getProperty("user.home") + "/Downloads";
		this.file = file;
		this.codeSegments = new ArrayList<>();
		this.eventPriority = EnumEventPriority.HIGH;
		if (file.getPath().endsWith(".xcfg")) {
			System.out.println("[DataUtils] Loaded Configuration File " + file.getPath());

		} else if (file.getPath().endsWith(".xdf")) {
			System.out.println("[DataUtils] Loaded Data File " + file.getPath());
		} else {
			String[] end = file.getPath().split(".");
			System.out.println("[DataUtils] " + end[end.length] + " files are not supported. Use at your own peril.");
		}
	}

	public void registerCodeSegment(ICodeSegment codeSegment) {
		codeSegments.add(codeSegment);
	}

	public void readFile() {
		for (ICodeSegment codeSegment : codeSegments) {
			codeSegment.onLoaded(eventPriority, "");
		}
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String s = reader.readLine();
			boolean running = false;
			if (s != null) {
				running = true;
			}
			boolean isBody = false;
			boolean isInRun = false;
			while (running) {
				if (s != null) {
					if (s.equals(DataFormatType.START) && !isBody) {
						isBody = true;
					} else if (s.equals(DataFormatType.END) && isBody) {
						isBody = false;
						running = false;
					} else {
						if (isBody) {
							eventPriority = EnumEventPriority.NORMAL;
							for (ICodeSegment codeSegment : codeSegments) {
								codeSegment.onLoaded(eventPriority, s);
							}
							if (s.split(" ")[0].equals(DataFormatType.RUN_START) && !isInRun) {
								isInRun = true;
								String name = s.split(" ")[1];
								System.out.println("[DataUtils] Running " + name);
							}
							if (s.split(" ")[0].equals(DataFormatType.RUN_END) && isInRun) {
								isInRun = false;
								System.out.println("[DataUtils] Stopped RUN");
							}
							if (s.split("=")[0].equals(DataFormatType.DOWNLOAD) && isInRun) {
								URL url;
								url = new URL(s.split("=")[1]);
								InputStream in = url.openStream();
								String mode = reader.readLine();
								String fileName = reader.readLine();
								System.out.print("[DataUtils] Downloading file");
								FileOutputStream out;
								switch (Integer.valueOf(mode)) {
								case 0:
									out = new FileOutputStream(new File(DOWNLOAD + "/" + fileName));
									break;
								case 1:
									out = new FileOutputStream(new File(reader.readLine() + fileName));
									break;
								default:
									out = new FileOutputStream(new File(DOWNLOAD + "/" + fileName));
									break;
								}
								int l = -1;
								byte[] buffer = new byte[1024];
								while ((l = in.read(buffer)) > -1) {
									out.write(buffer, 0, l);
								}
								out.close();
								in.close();
								System.out.print("[DataUtils] Downloaded " + fileName);
							}
							if (s.split("=")[0].equals(DataFormatType.READ) && isInRun) {
								String file = s.split("=")[1];
								System.out.println("[DataUtils] Reading File " + file);
								String mode = reader.readLine();
								FileManager manager = new FileManager(new File(file));
								System.out.println("[DataUtils] Loading FileManager mode=" + Integer.valueOf(mode));
								switch (Integer.valueOf(mode)) {
								case 0:
									System.out.println("[DataUtils] Loading FileManager");
									for (ICodeSegment segment : codeSegments) {
										manager.registerCodeSegment(segment);
									}
									break;
								case 1:
									break;
								default:
									break;
								}
								manager.readFile();
								System.out.println("[DataUtils] Finished File-Reading");
							}
						}

					}
					eventPriority = EnumEventPriority.LOW;
					for (ICodeSegment codeSegment : codeSegments) {
						codeSegment.onLoaded(eventPriority, s);
					}
					s = reader.readLine();
				} else {
					isBody = false;
					running = false;
				}

			}
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void writeToFile(String value, Object variable) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String s = reader.readLine();
			boolean running = false;
			if (s != null) {
				running = true;
			}
			boolean isBody = false;
			boolean exists = false;
			while (running) {
				if (s != null) {
					if (s.equals(DataFormatType.START) && !isBody) {
						isBody = true;
					} else if (s.equals(DataFormatType.END) && isBody) {
						isBody = false;
						running = false;
					} else {
						if (isBody) {
							if (s.split("=")[0].equals(value)) {
								exists = true;
								String[] stringArray = s.split("=");
								writer.write(stringArray[0] + "=" + variable);
							}
						}

					}
					s = reader.readLine();
					writer.newLine();
					if (s.endsWith(DataFormatType.END) && !exists) {
						writer.write(value + "=" + variable);
						writer.newLine();
						writer.write("}");
						isBody = false;
						running = false;
					}
				} else {
					isBody = false;
					running = false;
				}

			}
			reader.close();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public File getFile() {
		return file;
	}

}
