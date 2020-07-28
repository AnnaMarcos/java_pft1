package ru.stqa.pft.addressbook.test;

import com.google.common.base.Predicates;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class GroupDeletionTest extends TestBase {

  @BeforeMethod

  public void ensurePreconditions() {
    app.goTo().groupPage();
    if (app.group().all().size() == 0){
      app.group().create(new GroupData().withName("Test3"));
    }
  }

  @Test
  public void testGroupDeletion() throws Exception {
   Groups before = app.group().all();
    GroupData deletedGroup = before.iterator().next();
    app.group().delete(deletedGroup);
    app.goTo().groupPage();
    Groups after = app.group().all();
    assertEquals(after.size(), before.size() -1);
    assertThat(after, equalTo(before.without(deletedGroup)));

    }

}
