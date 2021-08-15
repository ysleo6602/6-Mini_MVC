package spms.controls;

import java.util.Map;

import javax.servlet.http.HttpSession;

import spms.dao.MemberDao;
import spms.vo.Member;

public class LogInController implements Controller {
  MemberDao memberDao;
  public LogInController setMemberDao(MemberDao memberDao) {
    this.memberDao = memberDao;
    return this;
  }
  
  @Override
  public String execute(Map<String, Object> model) throws Exception {
    
    if( model.get("member") == null) {
      return "/auth/LogInForm.jsp";
    } else {
      Member logIn = memberDao.exist(
          ((Member)model.get("member")).getEmail(),
          ((Member)model.get("member")).getPassword() );
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
