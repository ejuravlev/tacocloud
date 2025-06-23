package ru.ejuravlev.tacocloud.repository;

import ru.ejuravlev.tacocloud.models.TacoOrder;

public interface OrderRepository {
  void save(TacoOrder order);
}
