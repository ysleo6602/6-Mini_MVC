package spms.controls;

import java.util.Map;

import javax.servlet.http.HttpSession;

import spms.annotation.Component;
import spms.bind.DataBinding;
import spms.dao.MemberDao;
import spms.vo.Member;

@Component("/auth/login.do")
public class LogInController implements Controller, DataBinding {
  MemberDao memberDao;
  
  public LogInController setMemberDao(MemberDao memberDao) {
    this.memberDao = memberDao;
    return this;
  }
  
  public Object[] getDataBinders() {
    return new Object[] { "loginInfo", spms.vo.Member.class };
  }
  
  @Override
  public String execute(Map<String, Object> model) throws Exception {
    Member member = (Member)model.get("loginInfo");
    if(member.getEmail() == null) {
      return "/auth/LogInForm.jsp";
    } else {
      Member logIn = memberDao.exist(
          ((Member)model.get("loginInfo")).getEmail(),
          ((Member)model.get("loginInfo")).getPassword() );
      if(logIn != null) {
        HttpSession session  = (HttpSession)model.get("session");
        session.setAttribute("logIn", logIn);
        
        return "redirect:../member/list.do";
      } else {
        return "LogInFail.jsp";
        
      }
    }
  }
}
