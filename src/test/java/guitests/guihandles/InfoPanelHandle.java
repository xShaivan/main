package guitests.guihandles;

import javafx.scene.Node;
import javafx.scene.control.ScrollPane;

/**
 * A handler for the {@code InfoPanel} of the UI.
 */
public class InfoPanelHandle extends NodeHandle<Node> {
    public static final String INFO_PANEL_ID = "#infoPanel";
    //private boolean isWebViewLoaded = true;
    //private URL lastRememberedUrl;

    public InfoPanelHandle(Node infoPanelNode) {
        super(infoPanelNode);
        ScrollPane scrollPane = getChildNode(INFO_PANEL_ID);

        /*
        WebView webView = getChildNode(BROWSER_ID);
        WebEngine engine = webView.getEngine();
        new GuiRobot().interact(() -> engine.getLoadWorker().stateProperty().addListener((obs, oldState, newState) -> {
            if (newState == Worker.State.RUNNING) {
                isWebViewLoaded = false;
            } else if (newState == Worker.State.SUCCEEDED) {
                isWebViewLoaded = true;
            }
        }));
        */
    }

    /**
     * Returns the {@code URL} of the currently loaded page.
     */
    //public URL getLoadedUrl() {
    //    return WebViewUtil.getLoadedUrl(getChildNode(BROWSER_ID));
    //}

    /**
     * Remembers the {@code URL} of the currently loaded page.
     */
    //public void rememberUrl() {
    //    lastRememberedUrl = getLoadedUrl();
    //}

    /**
     * Returns true if the current {@code URL} is different from the value remembered by the most recent
     * {@code rememberUrl()} call.
     */
    //public boolean isUrlChanged() {
    //    return !lastRememberedUrl.equals(getLoadedUrl());
    //}

    /**
     * Returns true if the browser is done loading a page, or if this browser has yet to load any page.
     */
    //public boolean isLoaded() {
    //    return isWebViewLoaded;
    //}
}
