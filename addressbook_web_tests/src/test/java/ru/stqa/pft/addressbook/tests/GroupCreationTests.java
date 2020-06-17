package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() {
    app.getNavigationHelper().gotoGroupPage();
    List<GroupData> before = app.getGroupHelper().getGroupList();
    //int before = app.getGroupHelper().getGroupCount();//added verification: number of groups before creation new one
    GroupData group = new GroupData("test2", "test3", "test4");
    app.getGroupHelper().createGroup(group);
    //int after = app.getGroupHelper().getGroupCount(); //added verification: number of groups after creation new one
    List<GroupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size() + 1); // verification: after num = before num + one created

    //int max = 0;
    //for (GroupData g : after) {
    //if (g.getId() > max) {
    // max = g.getId();
    //}
    //}
    // int max1 = after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId();

    //group.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
    before.add(group);
    //Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
    Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }

}



