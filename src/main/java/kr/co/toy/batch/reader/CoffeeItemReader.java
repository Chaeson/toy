package kr.co.toy.batch.reader;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CoffeeItemReader<T> implements ItemReader<T> {

    private Queue<T> queue;

    public CoffeeItemReader(List<T> data){
        this.queue = new LinkedList<>(data);
    }


    @Override
    public T read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        return this.queue.poll();
    }
}
