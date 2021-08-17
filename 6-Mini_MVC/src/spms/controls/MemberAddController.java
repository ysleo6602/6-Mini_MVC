package spms.controls;

import java.util.Map;

import spms.bind.DataBinding;
import spms.dao.MemberDao;
import spms.vo.Member;

public class MemberAddController implements Controller, DataBinding {
  MemberDao memberDao;
  
  public MemberAddController setMemberDao(MemberDao memberDao) {
    this.memberDao = memberDao;
    return this;
  }
  
  public Object[] getDataBinders() {
    return new Object[] { "member", spms.vo.Member.class };
  }
  
  @Override
  public String execute(Map<String, Object> model) throws Exception {
    Member member = (Member)model.get("member");
    if(member.getEmail() == null ) {
      return "/member/MemberForm.jsp";
    } else {
      memberDao.insert(member);
      
      return "redirect:list.do";
    }
  }
}
