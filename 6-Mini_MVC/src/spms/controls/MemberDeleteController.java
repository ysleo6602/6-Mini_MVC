package spms.controls;

import java.util.Map;

import spms.dao.MemberDao;
import spms.vo.Member;

public class MemberDeleteController implements Controller {
  MemberDao memberDao;
  
  public MemberDeleteController setMemberDao(MemberDao memberDao) {
    this.memberDao = memberDao;
    return this;
  }
  
  public String execute(Map<String, Object> model) throws Exception {
    memberDao.delete( ((Member)(model.get("member"))).getNo() );
    
    return "redirect:list.do";
  }
}
