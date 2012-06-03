package com.az.clipboard;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

public class SetClipboard {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Toolkit tk = Toolkit.getDefaultToolkit();
		Clipboard cb = tk.getSystemClipboard();
		StringSelection ss = new StringSelection("qwerT");//The string that you want to set.
		cb.setContents(ss, ss);
	}

}
