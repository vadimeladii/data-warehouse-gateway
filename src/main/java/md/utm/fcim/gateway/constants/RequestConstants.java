package md.utm.fcim.gateway.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class RequestConstants {
    public static final String AUTHORIZATION = "Authorization";
    public static final String VERSION_HEADER = "X-Accept-Version";
    public static final String REQUEST_ID_HEADER = "requestId";
    public static final String USER_AGENT_HEADER = "User-Agent";
}
