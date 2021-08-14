package spms.controls;

import java.util.Map;

import spms.dao.MemberDao;
import spms.vo.Member;

public class MemberUpdateController implements Controller {
  @Override
  public String execute(Map<String, Object> model) throws Exception {
    MemberDao memberDao = (MemberDao)model.get("memberDao");
    if(((Member)model.get("member")).getEmail() == null) {
      model.put("member", memberDao.selectOne( ((Member)model.get("member")).getNo() ));
      
      return "MemberUpdateForm.jsp";
    } else {
      memberDao.update((Member)model.get("member"));
      return "redirect:list.do";
    }
  }
}
