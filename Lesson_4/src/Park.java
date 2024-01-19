import java.lang.reflect.Array;
import java.util.ArrayList;

public class Park {
    private final ArrayList<Attraction> attractionList;

    public Park() {
        attractionList = new ArrayList<>();
    }

    public ArrayList<Attraction> getAttractionList() {
        return attractionList;
    }

    public void addAttraction(String name, String workTime, int price) {
        attractionList.add(new Attraction(name, workTime, price));
    }

    public void removeAttraction(String name) {
        for (Attraction attraction : attractionList) {
            if (name.equals(attraction.getName())) {
                attractionList.remove(attraction);
                break;
            }
        }
    }

    public void printAttractionList() {
        for (Attraction attraction : attractionList) {
            System.out.println(attraction.toString());
        }
    }
    private class Attraction {
        private String name;
        private String workTime;
        private int price;

        public Attraction(String name, String workTime, int price) {
            this.name = name;
            this.workTime = workTime;
            this.price = price;
        }

        @Override
        public String toString() {
            return "Attraction{" +
                    "name='" + name + '\'' +
                    ", workTime='" + workTime + '\'' +
                    ", price=" + price +
                    '}';
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getWorkTime() {
            return workTime;
        }

        public void setWorkTime(String workTime) {
            this.workTime = workTime;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }
    }
}
