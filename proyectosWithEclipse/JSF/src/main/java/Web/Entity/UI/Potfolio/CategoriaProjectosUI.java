package Web.Entity.UI.Potfolio;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import Domain.dto.Potfolio.Project;
import Web.Entity.Enumerados.Category;
import Web.Entity.Enumerados.InventoryStatus;
import Web.Entity.Pojo.Portfolio.CategoriaProjectos;

import java.util.List;
import java.util.Random;
import java.util.ArrayList;

@ManagedBean
@ApplicationScoped
public class CategoriaProjectosUI {

    private List<CategoriaProjectos> listCategoriaProjectos;
    private static int countLikes = 0;

    public CategoriaProjectosUI() {
    	listCategoriaProjectos = new ArrayList<>();
    	listCategoriaProjectos.add(new CategoriaProjectos("Bamboo Watch","Product Description Bamboo Watch","bamboo-watch.jpg",65));
    	listCategoriaProjectos.add(new CategoriaProjectos("Black Watch","Product Description Black Watch", "black-watch.jpg", 72));
    	listCategoriaProjectos.add(new CategoriaProjectos("Blue Band","Product Description Blue Band","blue-band.jpg", 79));
    	listCategoriaProjectos.add(new CategoriaProjectos("Blue T-Shirt","Product Description Blue T-Shirt","blue-t-shirt.jpg", 29));
    	listCategoriaProjectos.add(new CategoriaProjectos("Bracelet", "Product Description Bracelet", "bracelet.jpg", 15));
    }

	public List<CategoriaProjectos> getListCategoriaProjectos() {
		return listCategoriaProjectos;
	}

	public void setListCategoriaProjectos(List<CategoriaProjectos> listCategoriaProjectos) {
		this.listCategoriaProjectos = listCategoriaProjectos;
	}
	
    public int getCountLikes() {return countLikes;}
	public void setCountLikes(int countLikes) {this.countLikes = countLikes;}
	
	public int increase() {
		return this.countLikes++;
	}

	public List<CategoriaProjectos> getListCategoriaProjectos(int size) {

        if (size > listCategoriaProjectos.size()) {
            Random rand = new Random();

            List<CategoriaProjectos> randomList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                int randomIndex = rand.nextInt(listCategoriaProjectos.size());
                randomList.add(listCategoriaProjectos.get(randomIndex));
            }

            return randomList;
        }

        else {
            return new ArrayList<>(listCategoriaProjectos.subList(0, size));
        }

    }

    public List<CategoriaProjectos> getClonedProducts(int size) {
        List<CategoriaProjectos> results = new ArrayList<>();
        List<CategoriaProjectos> originals = getListCategoriaProjectos(size);
        for (CategoriaProjectos original : originals) {
            results.add(original.clone());
        }
        return results;
    }
}