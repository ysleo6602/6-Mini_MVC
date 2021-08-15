package spms.controls;

import java.util.Map;

import spms.dao.MemberDao;
import spms.vo.Member;

public class MemberUpdateController implements Controller {
  MemberDao memberDao;
  
  public MemberUpdateController setMemberDao(MemberDao memberDao) {
    this.memberDao = memberDao;
    return this;
  }
  
  @Override
  public String execute(Map<String, Object> model) throws Exception {
    if(((Member)model.get("member")).getEmail() == null) {
      model.put("member", memberDao.selectOne( ((Member)model.get("member")).getNo() ));
      
      return "MemberUpdateForm.jsp";
    } else {
      memberDao.update((Member)model.get("member"));
      return "redirect:list.do";
    }
  }
}
