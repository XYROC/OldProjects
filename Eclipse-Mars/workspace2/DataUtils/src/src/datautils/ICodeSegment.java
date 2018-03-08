package src.datautils;

public abstract interface ICodeSegment {
	
	void onLoaded(EnumEventPriority eventPriority, String line);
	
}
