package spms.controls;

import java.util.Map;

import spms.bind.DataBinding;
import spms.dao.MemberDao;
import spms.vo.Member;

public class MemberUpdateController implements Controller, DataBinding {
  MemberDao memberDao;
  
  public MemberUpdateController setMemberDao(MemberDao memberDao) {
    this.memberDao = memberDao;
    return this;
  }
  
  public Object[] getDataBinders() {
    return new Object[] { "no", Integer.class, "member", spms.vo.Member.class };
  }
  
  @Override
  public String execute(Map<String, Object> model) throws Exception {
    Member member = (Member)model.get("member");
    if(member.getEmail() == null) {
      model.put("member", memberDao.selectOne( member.getNo() ));
      
      return "MemberUpdateForm.jsp";
    } else {
      memberDao.update(member);
      return "redirect:list.do";
    }
  }
}
