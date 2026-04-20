package reg;

 

public class MemberService {

    private MemberDAO dao = new MemberDAO();
    
    

    public int register(String username, String password, String gender, String role, String[] hobbies) throws Exception {       
        return dao.insertMember(username, password, gender, role, hobbies);
    }
}
