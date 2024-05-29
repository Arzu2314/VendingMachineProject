
public class ГорячийНапиток {
    private String name;
    private int volume;

    public ГорячийНапиток(String name, int volume) {
        this.name = name;
        this.volume = volume;
    }

    public String getName() {
        return name;
    }

    public int getVolume() {
        return volume;
    }
}

public class ГорячийНапитокСТемпературой extends ГорячийНапиток {
    private int температура;

    public ГорячийНапитокСТемпературой(String name, int volume, int температура) {
        super(name, volume);
        this.температура = температура;
    }

    public int getТемпература() {
        return температура;
    }
}

import java.util.ArrayList;
import java.util.List;

public class ГорячихНапитковАвтомат implements ТорговыйАвтомат {
    private List<ГорячийНапитокСТемпературой> напитки;

    public ГорячихНапитковАвтомат() {
        напитки = new ArrayList<>();
    }

    public void addНапиток(ГорячийНапитокСТемпературой напиток) {
        напитки.add(напиток);
    }

    @Override
    public ГорячийНапитокСТемпературой getProduct(String name, int volume, int температура) {
        for (ГорячийНапитокСТемпературой напиток : напитки) {
            if (напиток.getName().equals(name) && напиток.getVolume() == volume && напиток.getТемпература() == температура) {
                return напиток;
            }
        }
        return null;
    }
}

public class Main {
    public static void main(String[] args) {
        ГорячихНапитковАвтомат автомат = new ГорячихНапитковАвтомат();

        ГорячийНапитокСТемпературой чай = new ГорячийНапитокСТемпературой("Чай", 250, 80);
        ГорячийНапитокСТемпературой кофе = new ГорячийНапитокСТемпературой("Кофе", 200, 90);
        ГорячийНапитокСТемпературой какао = new ГорячийНапитокСТемпературой("Какао", 300, 75);

        автомат.addНапиток(чай);
        автомат.addНапиток(кофе);
        автомат.addНапиток(какао);

        ГорячийНапитокСТемпературой напиток = автомат.getProduct("Кофе", 200, 90);
        if (напиток != null) {
            System.out.println("Получен напиток: " + напиток.getName() + ", объем: " + напиток.getVolume() + " мл, температура: " + напиток.getТемпература() + "°C");
        } else {
            System.out.println("Напиток не найден.");
        }
    }
}
