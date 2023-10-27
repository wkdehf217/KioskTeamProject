import java.util.*;

public class Main {

    //전역변수로 사용하기 위해 menuAndID, catecoryID를 위로 뺐습니다.
    public static Map<String, Items> menuAndID = new HashMap<>();
    public static Map<String, String> categoryID = new HashMap<>();

    public static void main(String[] args) {
        Page page = new Page();
        page.addMenu();
        page.initPage();
    }

}

