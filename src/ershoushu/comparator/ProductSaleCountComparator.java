package ershoushu.comparator;
import java.util.Comparator;


import ershoushu.bean.Product;
public class ProductSaleCountComparator implements Comparator<Product>{

	@Override
	public int compare(Product p1, Product p2) {
		// TODO Auto-generated method stub
		return p2.getSaleCount()-p1.getSaleCount();
	}

}
