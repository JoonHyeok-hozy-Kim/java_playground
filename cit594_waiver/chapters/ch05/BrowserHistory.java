package cit594_waiver.chapters.ch05;

public class BrowserHistory {

    private Stack<String> history;

    public BrowserHistory(String homepage) {
        history = new LinkedListStack<>();
        history.push(homepage);
    }

    public void visit(String webpage) {
        System.out.println("visiting: " + webpage);
        history.push(webpage);
    }

    public void back() {
        history.pop();
        String lastPage = history.peek();
        System.out.println("returning to: " + lastPage);
    }

    public static void main(String[] args) {
        BrowserHistory myHistory = new BrowserHistory("Google");
        myHistory.visit("Gradescope");
        myHistory.visit("cis.upenn.edu/~cit5940");
        myHistory.visit("cis1100.com");
        myHistory.back();
        myHistory.visit("Canvas");
        myHistory.back();
        myHistory.back();
    }
}
