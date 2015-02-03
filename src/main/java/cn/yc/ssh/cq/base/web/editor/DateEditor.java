package cn.yc.ssh.cq.base.web.editor;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.util.StringUtils;

public class DateEditor extends PropertyEditorSupport {
	@Override
	public void setAsText(String text) throws IllegalArgumentException {

		if (!StringUtils.hasText(text)) {
			setValue(null);
		} else {
			try {
				setValue(new SimpleDateFormat("yyyy-MM-dd").parse(text));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public String getAsText() {

		return getValue().toString();
	}
}
