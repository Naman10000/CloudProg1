import java.util.Scanner;
class Video {
    String videoName;
    boolean checkout;
    int rating;
    public Video() {
    }
    public Video(String name) {
        videoName = name;
    }
    public String getName() {
        return videoName;
    }
    public void doCheckout() {
        System.err.println("Video " + '"' + getName() + '"' + " checked out successfully.");
    }
    public void doReturn() {
        checkout = true;
        System.err.println("Video " + '"' + getName() + '"' + " returned successfully.");
    }
    public void receiveRating(int rating) {
        this.rating = rating;
    }
    public int getRating() {
        return rating;
    }
    public boolean getCheckout() {
        return checkout;
    }
}
class VideoStore {
    Video[] store;
    int videoCount;
    public VideoStore() {
        store = new Video[5];
        videoCount = 0;
    }
    public void addVideo(String name) {
        if (videoCount < store.length) {
            store[videoCount++] = new Video(name);
            System.err.println("Video " + '"' + name + '"' + " added successfully");
        } else {
            System.err.println("Cannot add more videos. Video store is full.");
        }
    }
    public void doCheckout(String name) {
        for (int i = 0; i < videoCount; i++) {
            if (store[i].videoName.equals(name)) {
                store[i].doCheckout();
                return;
            }
        }
        System.err.println("Video " + '"' + name + '"' + " not found in the store.");
    }
    public void doReturn(String name) {
        for (int i = 0; i < videoCount; i++) {
            if (store[i].videoName.equals(name)) {
                store[i].doReturn();
                return;
            }
        }
        System.err.println("Video " + '"' + name + '"' + " not found in the store.");
    }
    public void receiveRating(String name, int rating) {
        for (int i = 0; i < videoCount; i++) {
            if (store[i].videoName.equals(name)) {
                store[i].receiveRating(rating);
                System.err.println("Rating " + '"' + rating + '"' + " has been mapped to the Video ''" + name + '"');
                return;
            }
        }
        System.err.println("Video " + '"' + name + '"' + " not found in the store.");
    }
    public void listInventory() {
        if (videoCount == 0) {
            System.out.println("Video store is empty.");
        } else {
            System.out.println("------------------------------------------");
            System.out.println("Video Name | Checkout Status | Rating");
            for (int i = 0; i < videoCount; i++) {
                System.out.println(store[i].getName() + "|" + store[i].getCheckout() + "|" + store[i].getRating());
            }
            System.out.println("------------------------------------------");
        }
    }
}
public class VideoLauncher {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice;
        VideoStore videoStore = new VideoStore();
        System.out.println("Naman Kumar");
        System.out.println("21BCS9938");
        do {
            System.out.println("MAIN MENU \n=========");
            System.out.println("1. Add Videos:");
            System.out.println("2. Check Out Video:");
            System.out.println("3. Return Video:");
            System.out.println("4. Receive Rating:");
            System.out.println("5. List Inventory:");
            System.out.println("6. Exit:");
            System.out.print("Enter your choice(1..6): ");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter the name of the video you want to add: ");
                    videoStore.addVideo(input.next());
                    break;
                case 2:
                    System.out.print("Enter the name of the video you want to check out: ");
                    videoStore.doCheckout(input.next());
                    break;
                case 3:
                    System.out.print("Enter the name of the video you want to Return:");
                    videoStore.doReturn(input.next());
                    ;
                    break;
                case 4:
                    System.out.println("Enter the name of the video you want to Rate: ");
                    videoStore.receiveRating(input.next(), input.nextInt());
                    break;
                case 5:
                    videoStore.listInventory();
                    break;
                case 6:
                    System.err.println("Exiting... Thanks for using the application");
                    break;
                default:
                    System.err.println("Invalid choice. Please choose a valid option.");
            }
        } while (choice != 6);
        input.close();
    }
}