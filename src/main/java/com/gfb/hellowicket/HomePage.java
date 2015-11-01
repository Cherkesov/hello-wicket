package com.gfb.hellowicket;

import com.gfb.hellowicket.dao.hibernate.UserDaoImpl;
import com.gfb.hellowicket.domain.User;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import java.util.List;

public class HomePage extends WebPage {
    private static final long serialVersionUID = 1L;

    @SpringBean
    private UserDaoImpl userDao;

    public HomePage(final PageParameters parameters) {
        super(parameters);

        add(new Label("version", getApplication().getFrameworkSettings().getVersion()));

        // TODO Add your page's components here

//        final List<User> users = userDao.load();
        final List<User> users = userDao.load();

        add(new ListView("listview", users) {
            protected void populateItem(ListItem item) {
                User user = (User) item.getModelObject();
                item.add(new Label("firstname", user.getUsername()));
                item.add(new Label("lastname", user.getPassword()));
            }
        });

//        DropDownChoice<User> ddc =
//                new DropDownChoice<User>("username",
//                        new PropertyModel<User>(null, "managedBy"),
//                        new LoadableDetachableModel<List<User>>() {
//                            @Override
//                            protected List<User> load() {
//                                return userDao.load();
//                            }
//                        }
//                );

    }
}