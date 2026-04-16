package day02;

import java.util.Random;

public class Teacher {
	
	
	
	public String getMessage() {
		
		 String[] messages = {
		            "오늘도 화이팅! 💪",
		            "넌 할 수 있어! 🚀",
		            "포기하지 마! 끝까지 가보자! 🔥",
		            "조금만 더 힘내면 좋은 일이 있을 거야! 😊",
		            "매일 조금씩 성장하는 너를 응원해! 🌱",
		            "자신을 믿어! 넌 멋진 사람이야! ✨",
		            "지금 힘들어도, 반드시 해낼 거야! 🏆"
		        };

        Random random = new Random();
        int index = random.nextInt(messages.length);
        
        System.out.println(messages[index]);
        
        return messages[index];
	}
	

	
}
