package ru.stqa.pft.addressbook.test;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;
import org.testng.annotations.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreationTest extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {
    app.goTo().groupPage();
    Groups before = app.group().all();
    GroupData group = new GroupData().withName("Test4");
    app.group().create(group);
    app.goTo().groupPage();
    assertThat(app.group().count(), equalTo(before.size() + 1));
    Groups after = app.group().all();
    assertThat (after, equalTo(before.withAdded
            (group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));


  }

    @Test
    public void testBadGroupCreation()  {

      app.goTo().groupPage();
      Groups before = app.group().all();
      GroupData group = new GroupData().withName("Test4'").withHeader("Test4").withFooter("Test4");
      app.group().create(group);
      app.goTo().groupPage();
      assertThat(app.group().count(), equalTo(before.size() ));
      Groups after = app.group().all();
      assertThat (after, equalTo(before));
    }
  }