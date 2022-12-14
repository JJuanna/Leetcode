package Test;

import BinaryTree.TrieTree;
import org.junit.Test;

public class SensitiveFilter {

    private TrieTree sensitiveFilter;
    @Test
    public void testSensitiveFilter() {
        sensitiveFilter = new TrieTree();
        sensitiveFilter.init();
        String text = "这里可以赌博,可以嫖娼,可以吸毒,可以开票,哈哈哈，日本人,日本鬼子，日，te,tea，赌，赌博!";
        text = sensitiveFilter.filter(text);
        System.out.println(text);

        text = "这里可以☆赌☆博☆,可以☆嫖☆娼☆,可以☆吸☆毒☆,可以☆开☆票☆,哈哈哈!";
        text = sensitiveFilter.filter(text);
        System.out.println(text);
    }
}
