import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CipherProgram {

    // Ключ для шифрования/дешифрования: массив символов для замены
    private static final char[] ENCRYPTION_KEY = {
            'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p',
            'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'z',
            'x', 'c', 'v', 'b', 'n', 'm', 'Q', 'W', 'E', 'R',
            'T', 'Y', 'U', 'I', 'O', 'P', 'A', 'S', 'D', 'F',
            'G', 'H', 'J', 'K', 'L', 'Z', 'X', 'C', 'V', 'B',
            'N', 'M', '1', '2', '3', '4', '5', '6', '7', '8',
            '9', '0', ' ', ',', '.', '!', '?'
    };

    // Метод для шифрования строки
    public static String encrypt(String input) {
        StringBuilder encrypted = new StringBuilder();
        for (char c : input.toCharArray()) {
            int index = getCharIndex(c);
            if (index != -1) {
                encrypted.append(ENCRYPTION_KEY[index]);
            } else {
                encrypted.append(c); // Если символ не найден в ключе, оставляем его без изменений
            }
        }
        return encrypted.toString();
    }

    // Метод для дешифрования строки
    public static String decrypt(String input) {
        StringBuilder decrypted = new StringBuilder();
        for (char c : input.toCharArray()) {
            int index = getKeyIndex(c);
            if (index != -1) {
                decrypted.append(getOriginalChar(index));
            } else {
                decrypted.append(c); // Если символ не найден в ключе, оставляем его без изменений
            }
        }
        return decrypted.toString();
    }

    // Получить индекс символа в оригинальном алфавите
    private static int getCharIndex(char c) {
        String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890 ,.!?";
        return alphabet.indexOf(c);
    }

    // Получить индекс символа в ключе
    private static int getKeyIndex(char c) {
        for (int i = 0; i < ENCRYPTION_KEY.length; i++) {
            if (ENCRYPTION_KEY[i] == c) {
                return i;
            }
        }
        return -1;
    }

    // Получить оригинальный символ по индексу
    private static char getOriginalChar(int index) {
        String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890 ,.!?";
        return alphabet.charAt(index);
    }

    // Основной метод для тестирования
    public static void main(String[] args) {
        // Текст для шифрования
        String originalText = "Alena Rybalko! The time is 12:34.";
        System.out.println("Original Text: " + originalText);

        // Шифрование текста
        String encryptedText = encrypt(originalText);
        System.out.println("Encrypted Text: " + encryptedText);

        // Дешифрование текста
        String decryptedText = decrypt(encryptedText);
        System.out.println("Decrypted Text: " + decryptedText);

        // Время отправки
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String timeString = now.format(formatter);
        System.out.println("\nOriginal Time: " + timeString);

        // Шифрование времени
        String encryptedTime = encrypt(timeString);
        System.out.println("Encrypted Time: " + encryptedTime);

        // Дешифрование времени
        String decryptedTime = decrypt(encryptedTime);
        System.out.println("Decrypted Time: " + decryptedTime);
    }
}