<%@page import="java.util.Calendar"%>
    <%@taglib prefix="tag" uri="http://www.adehermawan.com/dateFormatter"%>
    <header class="mdl-layout__header">
    <div class="mdl-layout__header-row">
       <!__Title__>
        <span class="mdl-layout-title">Personal rest3 Manager System</span>
        <!__Add spacer, to align navigation to the right__>
        <div class="mdl-layout-spacer"></div>
        <!__Navigation.We hide it in small screen.__>
        <tag:formatDate date="<%=Calendar.getInstance().getTime()%>"
                        format="dd-MM-YYYY hh:mm"></tag:formatDate>
        <nav class="mdl-navigation mdl-layout__large-screen-only">
            <a class="mdl-navigation__link" href="/PSMS/new">Add New rest3</a>
            <a class="mdl-navigation__link" href="/PSMS/new">List All rest3</a>
        </nav>
    </div>
    </header>
    <div class="mdl-layout__drawer">
        <span class="mdl-layout-title">PSMS</span>
        <nav class="mdl-navigation">
            <a class="mdl-navigation__link" href="/PSMS/new">Add New rest3</a>
            <a class="mdl-navigation__link" href="/PSMS/new">List All rest3</a>
        </nav>
    </div>
