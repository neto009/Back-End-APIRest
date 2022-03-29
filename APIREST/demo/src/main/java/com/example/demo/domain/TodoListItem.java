package com.example.demo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class TodoListItem {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String nomeDoItem;

    @ManyToOne
    private TodoList todolist;

    public TodoListItem(Integer id, String nomeDoItem, TodoList todolist) {
        this.id = id;
        this.nomeDoItem = nomeDoItem;
        this.todolist = todolist;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", nomeDoItem='" + getNomeDoItem() + "'" +
            ", todolist='" + getTodolist() + "'" +
            "}";
    }
}
