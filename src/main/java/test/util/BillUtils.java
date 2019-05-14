package test.util;

import test.model.Bill;
import test.model.Category;
import test.model.Product;

public class BillUtils {

    public static double calculateNetAmount(final Bill bill) {
        double percentDiscount = 0;
        if (bill.getCustomer().isEmployee()) {
            percentDiscount = 30;
        } else if (bill.getCustomer().isAffiliate()) {
            percentDiscount = 10;
        } else if (DateTimeUtils.yearDiffFromNow(bill.getCustomer().getRegisteredDate()) > 2) {
            percentDiscount = 5;
        }

        final double totalBillAmountWithoutDiscount = bill.getProducts().stream().mapToDouble(Product::getPrice).sum();
        final double percentDisountAmount = calculatePercentDiscountAmount(bill, percentDiscount);
        final double amountBaseDiscount = (int) (totalBillAmountWithoutDiscount - percentDisountAmount) / 100 * 5;

        System.out.println("totalBillAmountWithoutDiscount: " + totalBillAmountWithoutDiscount);
        System.out.println("percentDisountAmount: " + percentDisountAmount);
        System.out.println("amountBaseDiscount: " + amountBaseDiscount);

        return totalBillAmountWithoutDiscount - percentDisountAmount - amountBaseDiscount;
    }

    private static double calculatePercentDiscountAmount(final Bill bill, final double percentDiscount) {
        return bill.getProducts().stream().filter(o -> !isGroceries(o)).mapToDouble(o -> {
            return o.getPrice() * percentDiscount / 100;
        }).sum();
    }

    private static boolean isGroceries(final Product product) {
        final Category groceryCategory = new Category(2, "groceries");
//        final boolean b = product.getCategories().contains(groceryCategory);
//        System.out.println(product.getId() + ": " + b);
        final Category find = product.getCategories().stream()
                .filter(o -> o.getTitle().equals(groceryCategory.getTitle())).findAny().orElse(null);
        final boolean b = (find != null);
        return b;
    }

}
