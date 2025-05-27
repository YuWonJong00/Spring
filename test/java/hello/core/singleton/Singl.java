package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Singl {
    private static final Singl ac = new Singl();

    public static Singl getInstance() {
        return ac;
    }
    private Singl() {

    }
    public void logic(){
        System.out.println("싱글톤");
    }


}
