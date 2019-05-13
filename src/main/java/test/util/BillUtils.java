package test.util;

import test.model.Bill;
import test.model.Category;
import test.model.Product;

public class BillUtils {

    public static double calculateNetAmount(final Bill bill) {
        double percentDiscount = 0;
        if(bill.getCustomer().isEmployee()) {
            percentDiscount = 30;
        } else if(bill.getCustomer().isAffiliate()) {
            percentDiscount = 10;
        } else if(DateTimeUtils.yearDiffFromNow(bill.getCustomer().getRegisteredDate()) > 2) {
            percentDiscount = 5;
        }

        final double totalBillAmountWithoutDiscount = bill.getProducts().stream().mapToDouble(Product::getPrice).sum();
        final double percentDisountAmount = calculatePercentDiscountAmount(bill, percentDiscount);
        final double amountBaseDiscount = (totalBillAmountWithoutDiscount - percentDisountAmount) / 100 * 5;

        System.out.println("totalBillAmountWithoutDiscount: " + totalBillAmountWithoutDiscount);
        System.out.println("percentDisountAmount: " + percentDisountAmount);
        System.out.println("amountBaseDiscount: " + amountBaseDiscount);

        return totalBillAmountWithoutDiscount - percentDisountAmount - amountBaseDiscount;
    }

    private static double calculatePercentDiscountAmount(final Bill bill, final double percentDiscount) {
        return bill.getProducts().stream().filter(o -> isGroceries(o)).mapToDouble(o -> {
            return o.getPrice() * percentDiscount / 100;
        }).sum();
    }

    private static boolean isGroceries(final Product product) {
        final Category groceryCategory = new Category(2, "groceries");
        return product.getCategories().contains(groceryCategory);
    }

}
