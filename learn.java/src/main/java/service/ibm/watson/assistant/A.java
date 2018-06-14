package service.ibm.watson.assistant;

import com.ibm.watson.developer_cloud.assistant.v1.Assistant;
import com.ibm.watson.developer_cloud.assistant.v1.model.GetWorkspaceOptions;
import com.ibm.watson.developer_cloud.service.security.IamOptions;

class A {

    static void m(){
        IamOptions options = new IamOptions.Builder()
                .apiKey("{iam_api_key}")
                .build();

        Assistant assistant = new Assistant(
                "2018-02-16",
                "e5f14a0f-96eb-4e37-a9a4-2ae1c5769b26",
                "PZOTSkNeTA0z");


        assistant.setEndPoint("https://gateway-fra.watsonplatform.net/assistant/api");

        System.out.println(assistant.getEndPoint());
        assistant.createWorkspace();

        GetWorkspaceOptions options1 = new GetWorkspaceOptions.Builder().workspaceId("GetWorkspaceOptions").build();

        

    }

    public static void main(String[] args) {
        m();
    }
}
