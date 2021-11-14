//@Author Christian Dummer
package com.speechhelper.nullobjects;

import com.speechhelper.speechtotext.SpeechToTextReport;

public class NullSpeechToTextReport extends SpeechToTextReport{

	public NullSpeechToTextReport() {
		this.datapoints = "";
		this.feedback = "";
	}
}
