
public class SimpleCpu {
	
	int[] mem_;
	int acc_;
	int pc_;
	int ir_;
	
	public static final int NOP = 0;
	public static final int LOAD = 42;
	public static final int LOADA = 1;
	public static final int STORE = 2;
	public static final int ADD = 3;
	public static final int SUB = 4;
	public static final int MULT = 5;
	public static final int JMPNEG = 6;
	public static final int JMPEQ = 7;
	public static final int JLE = 8;
	public static final int JMP = 9;
	public static final int NOT = 10;
	public static final int NEG = 11;
	public static final int HALT = 12;
	public static final int DIV = 13;
	

	public SimpleCpu(){
		mem_ = new int[128];
		this.reset();
	}

	public static void main(String[] args) {
		System.out.println("Cpu started!");
		SimpleCpu cpu = new SimpleCpu();
		cpu.loadProgram();
		cpu.run();
	}
	public void reset(){
		for(int i = 0;i < mem_.length;i++){
			mem_[i] = 0;
			acc_ = 0;
			pc_ = 0;
		}
	}
	public void fetch(){
		ir_ = mem_[pc_];
		pc_++;
		if(pc_ > 127){
			reset();
		}
	}
	public void run(){
		boolean running = true;
		while(running){
			System.out.println("CPU:"+"pc_:"+pc_+" | acc:"+acc_+" |ir:"+ir_);
			fetch();
			switch(ir_){
				case HALT: 
					System.out.println("CPU:HALT");
					running = false;
					break;
				case LOAD:
					acc_ = mem_[mem_[pc_++]];
					System.out.println("CPU:LOAD ("+acc_+")");
					break;
				case LOADA:
					System.out.println("CPU:LOADA");
					acc_ = mem_[acc_];
					break;
				case ADD:
					System.out.println("CUP:ADD  mem_ :("+mem_[pc_+1]+")");
					acc_ = acc_ + mem_[pc_++];
					acc_ = mem_[acc_];
					break;
				case STORE:
					System.out.println("CPU:STORE mem_ :("+mem_[pc_+1]+")");
					mem_[pc_++] = acc_;
					break;
				case JMP:
					System.out.println("CPU:JUMP ("+mem_[pc_]+")");
					pc_ = mem_[pc_];
					break;
				case JMPNEG:
					System.out.println("CPU:JUMPNEG ("+mem_[pc_]+")");
					if(acc_ < 0){
						pc_ = mem_[pc_];
					}
					break;
				case JMPEQ:
					System.out.println("CPU:JUMPEQ ("+mem_[pc_]+")");
					if(acc_ == 0){
						pc_ = mem_[pc_];
					}
				case JLE:
					System.out.println("CPU:JLE ("+mem_[pc_]+")");
					if(acc_ <= 0){
						pc_ = mem_[pc_];
					}
					break;
				case SUB:
					System.out.println("CUP:SUB");
					acc_ = acc_ - mem_[pc_++];
					break;
				case MULT:
					System.out.println("CPU:MULT");
					acc_ = acc_ * mem_[pc_++];
					break;
				case DIV:
					System.out.println("CPU:DIV");
					if(mem_[pc_] == 0){
						System.out.println("CPU:DIV FAILURE! RESETTING...");
						this.reset();
					}else{
						acc_ = acc_ / mem_[pc_++];
					}
					break;
				case NOT:
					System.out.println("CPU:NOT");
					acc_ = ~acc_;
					break;
				case NOP:
					System.out.println("CPU:NOP");
					break;
				default:
					System.out.println("CPU: ILLEGAL OPCODE EXEPTION");
					running = false;
					break;
					
			}
		}
		this.dumpMemory();
	}
	public void loadProgram(){
		mem_[101] = 0;
		mem_[102] = 30;
		mem_[0] = LOAD;
		mem_[1] = 101;
		mem_[90] = LOAD;
		mem_[91] = 102;
		mem_[92] = STORE;
		mem_[93] = 103;
		mem_[94] = HALT;
		
	}
	public void dumpMemory(){
		for(int i = 0; i < 127; i++){
			System.out.println("CPU:MEMORYDUMP mem_ "+i+" = "+mem_[i]);
		}
	}

}
