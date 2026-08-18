import java.util.*;

public class woedLadder {

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Set<String> set = new HashSet<>(wordList);

        // endWord must be present
        if (!set.contains(endWord)) {
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        int level = 1;

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                String word = queue.poll();
                char[] chars = word.toCharArray();

                // Change each character
                for (int j = 0; j < chars.length; j++) {

                    char original = chars[j];

                    for (char c = 'a'; c <= 'z'; c++) {

                        chars[j] = c;

                        String nextWord = new String(chars);

                        if (nextWord.equals(endWord)) {
                            return level + 1;
                        }

                        if (set.contains(nextWord)) {
                            queue.offer(nextWord);
                            set.remove(nextWord);
                        }
                    }

                    chars[j] = original;
                }
            }

            level++;
        }

        return 0;
    }

    public static void main(String[] args) {

        String beginWord = "hit";
        String endWord = "cog";

        List<String> wordList = Arrays.asList(
                "hot",
                "dot",
                "dog",
                "lot",
                "log",
                "cog"
        );

        int answer = ladderLength(beginWord, endWord, wordList);

        System.out.println("Answer: " + answer);
    }
}