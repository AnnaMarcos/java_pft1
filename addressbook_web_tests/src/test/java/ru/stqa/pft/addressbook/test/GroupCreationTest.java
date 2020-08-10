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

  @DataProvider
  public Iterator<Object[]>validGroups() {
    List<Object[]> list = new ArrayList<Object[]>();
    list.add (new Object[] { new GroupData().withName("Test 1").withHeader("Header 1").withFooter("Footer 1")});
    list.add (new Object[] { new GroupData().withName("Test 2").withHeader("Header 2").withFooter("Footer 2")});
    list.add (new Object[] { new GroupData().withName("Test 3").withHeader("Header 3").withFooter("Footer 3")});
    return list.iterator();
  }

  @Test (dataProvider = "validGroups")
  public void testGroupCreation(GroupData group) throws Exception {
      app.goTo().groupPage();
      Groups before = app.group().all();
      app.group().create(group);
      app.goTo().groupPage();
      assertThat(app.group().count(), equalTo(before.size() + 1));
      Groups after = app.group().all();
      assertThat(after, equalTo(before.withAdded
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