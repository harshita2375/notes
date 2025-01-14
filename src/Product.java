public class Product {
    private String partA;
    private String partB;
    private String partC;

    private Product(Builder builder) {
        this.partA = builder.partA;
        this.partB = builder.partB;
        this.partC = builder.partC;
    }

    public static class Builder {
        private String partA;
        private String partB;
        private String partC;

        public Builder setPartA(String partA) {
            this.partA = partA;
            return this;
        }

        public Builder setPartB(String partB) {
            this.partB = partB;
            return this;
        }

        public Builder setPartC(String partC) {
            this.partC = partC;
            return this;
        }

        public Product build() {
            return new Product(this);
        }
    }

    @Override
    public String toString() {
        return "Product [partA=" + partA + ", partB=" + partB + ", partC=" + partC + "]";
    }
}

public class FluentBuilderDemo {
    public static void main(String[] args) {
        Product product = new Product.Builder()
                .setPartA("Part A")
                .setPartB("Part B")
                .setPartC("Part C")
                .build();

        System.out.println(product);
    }
}


PRoduct p = new Product.Builder().setprop1().setProp2().build();