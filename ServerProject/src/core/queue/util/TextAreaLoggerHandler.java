package core.queue.util;

import GUI.GUIForm;

import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.logging.StreamHandler;

public class TextAreaLoggerHandler extends StreamHandler {


    @Override
    public void publish(LogRecord record) {

        super.publish(record);
        GUIForm.getGuiForm().appendToLoggerText(getFormatter().format(record));
        System.out.println("debuginisdelogrecord");
        flush();



    }



}
