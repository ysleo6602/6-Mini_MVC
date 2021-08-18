package spms.controls;

import java.util.Map;

import spms.annotation.Component;
import spms.bind.DataBinding;
import spms.dao.MemberDao;
import spms.vo.Member;

@Component("/member/delete.do")
public class MemberDeleteController implements Controller, DataBinding {
  MemberDao memberDao;
  
  public MemberDeleteController setMemberDao(MemberDao memberDao) {
    this.memberDao = memberDao;
    return this;
  }
  
  public Object[] getDataBinders() {
    return new Object[] { "no", Integer.class };
  }
  
  public String execute(Map<String, Object> model) throws Exception {
    Member member = (Member)model.get("member");
    memberDao.delete( member.getNo() );
    
    return "redirect:list.do";
  }
}
