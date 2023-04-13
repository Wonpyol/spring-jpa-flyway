package com.study.repository;

import static org.junit.jupiter.api.Assertions.*;

import com.study.entity.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest

class MemberRepositoryTest {

  @Autowired
  private MemberRepository repository;

  @Test
  void save() {
    Member member = Member.builder().age("20").name("wonpyol").address("파주시").address1("345").build();
    repository.save(member);
    assertTrue(member.getId() > 0);
  }

  @Test
  void findById() {
    Member member = Member.builder().age("20").name("wonpyol find").address("파주시").address1("345").build();
    repository.save(member);
    Member find = repository.findById(member.getId()).orElse(null);
    assertNotNull(find);
  }

}