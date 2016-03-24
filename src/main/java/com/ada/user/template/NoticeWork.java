package com.ada.user.template;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ada.site.dao.TemplateNoticeDao;
import com.ada.site.entity.TemplateNotice;
import com.ada.user.dao.UserNotificationDao;
import com.ada.user.dao.UserNotificationMemberDao;
import com.ada.user.entity.UserInfo;
import com.ada.user.entity.UserNotification;
import com.ada.user.entity.UserNotificationMember;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import jodd.util.StringTemplateParser;

@Component
@Transactional
public class NoticeWork implements NoticeApi {

	@Autowired
	TemplateNoticeDao noticeDao;

	@Autowired
	UserNotificationDao userNotificationDao;

	@Autowired
	UserNotificationMemberDao notificationMemberDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ada.user.template.NoticeApi#push(java.lang.String,
	 * java.util.Map, java.lang.Long)
	 */
	
	@Transactional
	@Override
	public int push(String templateid, Map<String, String> keys, Long... users) {
		int result = 0;
		TemplateNotice notice = noticeDao.findById(templateid);

		Configuration config = new Configuration(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS);
		try {

			Template template = new Template(notice.getId(), notice.getNote(), config);
			Writer out = new StringWriter();
			template.process(keys, out);
			String msg = out.toString();
			UserNotification bean = new UserNotification();
			bean.setAddDate(new Date());
			bean.setLastDate(new Date());
			bean.setTitle(notice.getTitle());
			bean.setNote(msg);
			bean.setCategory(0);
			userNotificationDao.save(bean);

			if (users != null) {
				for (Long user : users) {
					UserNotificationMember xx = new UserNotificationMember();
					xx.setState(0);
					xx.setNotification(bean);
					xx.setUser(UserInfo.fromId(user));
					xx.setAddDate(new Date());
					xx.setLastDate(new Date());
					notificationMemberDao.save(xx);
				}
			}
			result = 1;
		} catch (TemplateException e) {
			result = -1;
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			result = -1;
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ada.user.template.NoticeApi#pushjodd(java.lang.String,
	 * java.util.Map, java.lang.Long)
	 */
	@Transactional
	@Override
	public int pushjodd(String templateid, Map<String, String> keys, Long... users) {
		int result = 0;
		TemplateNotice notice = noticeDao.findById(templateid);
		try {
			StringTemplateParser stp = new StringTemplateParser();

			String msg = stp.parse(notice.getNote(), StringTemplateParser.createMapMacroResolver(keys));
			UserNotification bean = new UserNotification();
			bean.setAddDate(new Date());
			bean.setLastDate(new Date());
			bean.setTitle(notice.getTitle());
			bean.setNote(msg);
			bean.setCategory(0);
			userNotificationDao.save(bean);
			if (users != null) {
				for (Long user : users) {
					UserNotificationMember xx = new UserNotificationMember();
					xx.setState(0);
					xx.setNotification(bean);
					xx.setUser(UserInfo.fromId(user));
					xx.setAddDate(new Date());
					xx.setLastDate(new Date());
					notificationMemberDao.save(xx);
				}
			}
			result = 1;
		} catch (Exception e) {
			e.printStackTrace();
			result = -1;
		}
		return result;
	}
}
