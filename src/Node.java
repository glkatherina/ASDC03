public class Node {
        private Menu data;
        private Node left;
        private Node right;

        public Node(Menu data) {
                this.data = data;
                left = null;
                right = null;
        }

        public Menu getData() {
                return data;
        }

        public Node getLeft() {
                return left;
        }

        public void setLeft(Node left) {
                this.left = left;
        }

        public Node getRight() {
                return right;
        }

        public void setRight(Node right) {
                this.right = right;
        }
}
