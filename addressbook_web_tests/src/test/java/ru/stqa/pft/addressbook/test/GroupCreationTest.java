package ru.stqa.pft.addressbook.test;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import static afu.org.checkerframework.checker.units.UnitsTools.g;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreationTest extends TestBase {


  @DataProvider
  public Iterator<Object[]>validGroups() throws IOException {
    List<Object[]> list = new ArrayList<Object[]>();
    try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/groups.csv")))) {
      String line = reader.readLine();
      while (line != null) {
        String[] split = line.split(";");
        list.add(new Object[]{new GroupData().withName(split[0]).withHeader(split[1]).withFooter(split[2])});
        line = reader.readLine();
      }
      return list.iterator();
    }
  }

  @DataProvider
  public Iterator<Object[]>validGroupsFromXML() throws IOException {
   try(BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/groups.xml")))){
    String xml = "";
    String line = reader.readLine();
    while (line != null) {
      String []split =  line.split(";");
      xml += line;
      line = reader.readLine();
    }
    XStream xStream = new XStream();
    xStream.processAnnotations(GroupData.class);
    List <GroupData> groups = (List<GroupData>) xStream.fromXML(xml);
    return groups.stream().map((g) -> new Object[] {g}).collect (Collectors.toList()).iterator();
    }
  }
  @DataProvider
  public Iterator<Object[]>validGroupsFromJson() throws IOException {
    try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/groups.json")))) {
      String json = "";
      String line = reader.readLine();
      while (line != null) {
        String[] split = line.split(";");
        json += line;
        line = reader.readLine();
      }
      Gson gson = new Gson();
      List<GroupData> groups = gson.fromJson(json, new TypeToken<List<GroupData>>() {}.getType());
      return groups.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();
    }
  }


  @Test (dataProvider = "validGroupsFromJson")
  public void testGroupCreation(GroupData group) throws Exception {
      app.goTo().groupPage();
      Groups before = app.db().groups();
      app.group().create(group);
      app.goTo().groupPage();
      assertThat(app.group().count(), equalTo(before.size() + 1));
      Groups after = app.db().groups();
      assertThat(after, equalTo(before.withAdded
              (group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
  }

    @Test
    public void testBadGroupCreation()  {

      app.goTo().groupPage();
      Groups before = app.db().groups();
      GroupData group = new GroupData().withName("Test4'").withHeader("Test4").withFooter("Test4");
      app.group().create(group);
      app.goTo().groupPage();
      assertThat(app.group().count(), equalTo(before.size() ));
      Groups after = app.db().groups();
      assertThat (after, equalTo(before));
    }
  }