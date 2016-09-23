package Mock;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.mockito.Mockito.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

/**
 * @author dreamyao
 *         Created by dreamyao on 16-9-23.
 */
public class MockitoSampleTest {
    //① 对接口进行模拟
    UserService mockUserService = mock(UserService.class);
    //② 对类进行模拟
    UserServiceImpl mockServiceImpl = mock(UserServiceImpl.class);
    //③ 基于注解模拟类
    @Mock
    User mockUser;

    @BeforeClass
    public void initMocks() {
        //④ 初始化当前测试类所有@Mock注解模拟对象
        MockitoAnnotations.initMocks(this);
    }

    //① 模拟接口UserService测试
    @Test
    public void testMockInterface() {
        //①-1 对方法设定返回值
        when(mockUserService.findUserByUserName("tom")).thenReturn(
                new User("tom", "1234"));
        //①-2 对方法设定返回值
        doReturn(true).when(mockServiceImpl).hasMatchUser("tom", "1234");
        //①-3 对void方法进行方法预期设定
        User u = new User("John", "1234");
        doNothing().when(mockUserService).registerUser(u);

        //①-4 执行方法调用
        User user = mockUserService.findUserByUserName("tom");
        boolean isMatch = mockUserService.hasMatchUser("tom", "1234");
        mockUserService.registerUser(u);

        System.out.println(user);
        System.out.println(user.getUserName());
        System.out.println(isMatch);
        assertNotNull(user);
        assertEquals(user.getUserName(), "tom");
        assertEquals(isMatch, false);
    }

    //② 模拟实现类UserServiceImpl测试
    @Test
    public void testMockClass() {
        // 对方法设定返回值
        when(mockServiceImpl.findUserByUserName("tom"))
                .thenReturn(new User("tom", "1234"));
        doReturn(true).when(mockServiceImpl).hasMatchUser("tom", "1234");

        User user = mockServiceImpl.findUserByUserName("tom");
        boolean isMatch = mockServiceImpl.hasMatchUser("tom", "1234");
        assertNotNull(user);
        assertEquals(user.getUserName(), "tom");
        assertEquals(isMatch, true);
    }

    //③ 模拟User类测试
    @Test
    public void testMockUser() {
        when(mockUser.getUserId()).thenReturn("1");
        when(mockUser.getUserName()).thenReturn("tom");
        assertEquals(mockUser.getUserId(), "1");
        assertEquals(mockUser.getUserName(), "tom");
    }

    //① 模拟接口UserService测试
    @Test
    public void testMockInterface1() {

        when(mockUserService.findUserByUserName("tom"))
                .thenReturn(new User("tom", "1234"));
        User user = mockServiceImpl.findUserByUserName("tom");
        boolean isMatch = mockUserService.hasMatchUser("tom", "1234");

        //①-4 验证返回值
        assertNotNull(user);
        assertEquals(user.getUserName(), "tom");
        assertEquals(isMatch, true);

        //①-5 验证交互行为
        verify(mockUserService).findUserByUserName("tom");

        //①-6 验证方法至少调用一次
        verify(mockUserService, atLeastOnce()).findUserByUserName("tom");
        verify(mockUserService, atLeast(1)).findUserByUserName("tom");

        //①-7 验证方法至多调用一次
        verify(mockUserService, atMost(1)).findUserByUserName("tom");
    }
}
