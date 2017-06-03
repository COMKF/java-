package bean;

import java.io.File;
import java.io.FilenameFilter;

public class FilterByStartName implements FilenameFilter{
	private String suffix;
	public FilterByStartName(String suffix){
		this.suffix = suffix;
	}
	public boolean accept(File dir, String name) {
		
		return name.startsWith(suffix);
	}

}
