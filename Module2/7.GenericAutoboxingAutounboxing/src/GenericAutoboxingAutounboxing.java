public class GenericAutoboxingAutounboxing {


    public static void main(String[] args) throws Exception{
        Integer[] integers1 = {3,2,2};
        ArrayWrapper<Integer> arrayWrapper1 = new ArrayWrapper<>(integers1);
        Integer[] integers2 = {3,2,2};
        ArrayWrapper<Integer> arrayWrapper2 = new ArrayWrapper<>(integers2);

        Integer[] integers3 = {1,2,2};
        ArrayWrapper<Integer> arrayWrapper3 = new ArrayWrapper<>(integers3);

        Integer[] integers4 = {3,2,2,2};
        ArrayWrapper<Integer> arrayWrapper4 = new ArrayWrapper<>(integers4);

        System.out.println(arrayWrapper1.isEqualTo(arrayWrapper2));
        System.out.println(arrayWrapper1.isEqualTo(arrayWrapper3));
        System.out.println(arrayWrapper1.isEqualTo(arrayWrapper4));

        System.out.println("Изначальный массив: " + arrayWrapper1);
        arrayWrapper1.swap(0, 2);
        System.out.println("После обмена позициями индексов: " + arrayWrapper1);

    }
}
