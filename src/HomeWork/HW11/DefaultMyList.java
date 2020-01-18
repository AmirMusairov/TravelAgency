package HW11;
import java.util.Iterator;

public class DefaultMyList<E> implements MyList<E>, ListIterable {

        protected Object[] data = new Object[1];
        private int countObj = 0;

        public void add(E e) {

            Object[] modifiedData = new Object[countObj + 1];
            for (int i = 0; i < data.length; i++) {
                modifiedData[i] = data[i];
            }
            data = modifiedData;
            data[countObj] = e;
            countObj++;
        }

        public Object get(int index) {

            return data[index];
        }

        public void clear() {

            data = new Object[1];
        }

        public boolean remove(Object o) {

            Object[] modifiedData = new Object[data.length - 1];
            int count = -1;

            for (int i = 0; i < data.length; i++) {

                if (data[i].equals(o)) {

                    count++;
                }

                if (count == -1 && i == data.length - 1) {
                    return false;
                }

            }

            for (int i = 0; i < data.length; i++) {

                if (!data[i].equals(o)) {
                    modifiedData[count] = data[i];
                    count++;
                }

            }
            data = modifiedData;
            return true;
        }

        public Object[] toArray() {

            return data;
        }

        public int size() {

            return data.length;
        }

        public boolean contains(E o) {

            for (int i = 0; i < data.length; i++) {

                if (data[i].equals(o)) {
                    return true;
                }
            }

            return false;
        }

        public boolean containsAll(MyList c) {

            Object[] modifiedData = c.toArray();

            int count = 0;

            for (int i = 0; i < data.length; i++) {

                for (int j = 0; j < c.size(); j++) {
                    if (data[i].equals(modifiedData[j])) {
                        count++;
                    }
                }
                if (count == modifiedData.length - 1) {
                    return true;
                }
            }

            return false;
        }

        public Iterator<Object> iterator() {
            return new IteratorImpl();
        }

        private class IteratorImpl implements Iterator<Object> {

            int index;
            int count;

            public boolean hasNext() {

                return (index < data.length) ? true : false;
            }

            public Object next() {
                count = 0;
                return (hasNext()) ? data[index++] : null;

            }

            public void remove() {
                if (count == 0) {
                    DefaultMyList.this.remove(data[index]);
                    count++;
                } else {
                    throw new IllegalStateException();
                }
            }

        }

        public ListIterator listIterator() {
            return new ListIteratorImpl();
        }

        private class ListIteratorImpl extends IteratorImpl implements ListIterator {

            public boolean hasPrevious() {
                return (index > 0) ? true : false;
            }

            public Object previous() {
                count = 0;
                return (hasPrevious()) ? data[index--] : null;
            }

            public void set(Object e) {

                if (count == 0) {
                    data[index] = e;
                    count++;
                } else {
                    throw new IllegalStateException();
                }

            }
        }
    }
