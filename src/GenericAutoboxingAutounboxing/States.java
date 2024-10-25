package GenericAutoboxingAutounboxing;

import java.util.Arrays;

public class States<T extends Number> {
    private T[] values;

    T at(int idx){
        return values[idx];
    }

    T[] getValues(){
        return values;
    }

    States(T[] values){
        this.values = values;
    }

    void setValues(T[] values){
        this.values = values;
    }

    void setValue(T value, int idx) throws Exception{
        if(idx < 0 || idx > values.length){
            throw new Exception("Out of range");
        }

        values[idx] = value;
    }

    public int length(){
        return values.length;
    }

    public double getAverage(){
        double sum = 0;
        for(T value : values){
            sum += value.doubleValue();
        }

        return sum / values.length;
    }

    public void swap(int lhs, int rhs){
        T tmp = values[lhs];
        values[lhs] = values[rhs];
        values[rhs] = tmp;
    }

    public boolean isEqualTo(States<T> rhs){
        if(this.length() != rhs.length()) return false;
        for(int i = 0; i < this.length(); ++i){
            if(this.at(i) != rhs.at(i)) return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return Arrays.toString(values);
    }
}
