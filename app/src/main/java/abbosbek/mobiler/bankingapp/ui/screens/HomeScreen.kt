package abbosbek.mobiler.bankingapp.ui.screens

import abbosbek.mobiler.bankingapp.R
import abbosbek.mobiler.bankingapp.data.SendMoneyItem
import abbosbek.mobiler.bankingapp.ui.theme.CardRed
import abbosbek.mobiler.bankingapp.ui.theme.LightGrey2
import abbosbek.mobiler.bankingapp.ui.theme.PrimaryGrey
import abbosbek.mobiler.bankingapp.ui.theme.Purple40
import abbosbek.mobiler.bankingapp.ui.theme.Service1
import abbosbek.mobiler.bankingapp.ui.theme.Service2
import abbosbek.mobiler.bankingapp.ui.theme.Service3
import abbosbek.mobiler.bankingapp.ui.theme.Service4
import abbosbek.mobiler.bankingapp.ui.theme.poppins
import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen() {

    val sendMyData = mutableListOf(
        SendMoneyItem(R.drawable.user1,"Jimmy","$55.90"),
        SendMoneyItem(R.drawable.user2,"Kate","$12.60"),
        SendMoneyItem(R.drawable.user3,"Smith","$40.500"),
        SendMoneyItem(R.drawable.user,"Chris","$30.70")
    )

    Column(
    ) {
        HeaderUI()
        CardUI()
        DataUI()
        ServicesUI()
        SendMoneyUI(sendMyData)
    }
}

@Composable
fun SendMoneyUI(sendMyData: MutableList<SendMoneyItem>) {

    Column(modifier = Modifier
        .padding(horizontal = 20.dp)
        .padding(top = 16.dp)
    ) {
        Text(
            text = "Send Money",
            color = PrimaryGrey,
            fontFamily = poppins,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(10.dp))
        LazyRow{
            items(sendMyData){item->
                SendMoneyItemUI(item)
            }
        }
    }

}

@Composable
fun SendMoneyItemUI(item: SendMoneyItem) {
    Card(
        modifier = Modifier
            .padding(end = 6.dp)
            .border(width = 0.dp, color = LightGrey2, shape = ShapeDefaults.Medium),
        elevation = CardDefaults.cardElevation(0.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(
            modifier = Modifier
                .size(width = 100.dp, height = Dp.Unspecified)
                .padding(top = 6.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            
            Image(
                painter = painterResource(id = item.imageId),
                contentDescription = "",
                modifier = Modifier.size(60.dp)
            )

            Text(
                text = item.name,
                color = PrimaryGrey,
                modifier = Modifier
                    .alpha(0.6f)
                    .padding(top = 6.dp),
                style = TextStyle(
                    fontSize = 12.sp,
                    fontFamily = poppins,
                    fontWeight = FontWeight.SemiBold
                )
            )

            Text(
                text = item.amount,
                color = PrimaryGrey,
                modifier = Modifier
                    .alpha(0.8f),
                style = TextStyle(
                    fontSize = 14.sp,
                    fontFamily = poppins,
                    fontWeight = FontWeight.Bold,
                )
            )



        }

    }
    
}

@Composable
fun ServicesUI() {

    Column(modifier = Modifier.padding(horizontal = 20.dp)) {
        Text(
            text = "Services",
            color = PrimaryGrey,
            fontFamily = poppins,
            fontWeight = FontWeight.Bold
        )
        
        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(10.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            ServiceUI(R.drawable.ic_money_send,"Send", Service1)
            ServiceUI(R.drawable.ic_bill,"Bill", Service2)
            ServiceUI(R.drawable.ic_recharge,"Recharge", Service3)
            ServiceUI(R.drawable.ic_more,"More", Service4)
        }
    }

}

@Composable
fun ServiceUI(id: Int, text: String, color: Color) {

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        OutlinedButton(
            onClick = {},
            modifier = Modifier.size(60.dp),
            shape = CircleShape,
            contentPadding = PaddingValues(0.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White,
                contentColor = color
            )
        ) {
            Icon(painter = painterResource(id = id), contentDescription = "")
        }
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = text,
            color = PrimaryGrey,
            modifier = Modifier.alpha(0.6f),
            fontSize = 14.sp,
            fontFamily = poppins,
            fontWeight = FontWeight.SemiBold
        )
    }

}

@Composable
fun DataUI() {
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 20.dp, vertical = 30.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        Column {
            Text(
                text = "$87.50K",
                color = PrimaryGrey,
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = poppins,
                lineHeight = 20.sp
            )
            
            Text(
                text = "Total Income",
                color = PrimaryGrey,
                fontFamily = poppins,
                modifier = Modifier.alpha(0.6f),
                fontSize = 16.sp
            )
        }

        Column {
            Text(
                text = "$12.30K",
                color = PrimaryGrey,
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = poppins,
                lineHeight = 20.sp
            )

            Text(
                text = "Total Spent",
                color = PrimaryGrey,
                fontFamily = poppins,
                modifier = Modifier.alpha(0.6f),
                fontSize = 16.sp
            )
        }
    }

}

@Composable
fun CardUI() {

    Card(
        modifier = Modifier
            .padding(horizontal = 20.dp)
            .fillMaxWidth()
            .height(160.dp),
        colors = CardDefaults.cardColors(containerColor = CardRed)
    ) {
        Row(
            modifier = Modifier.padding(20.dp)
        ){
            Column(
            ) {
                Text(
                    text = "Balance",
                    color = Color.White,
                    modifier = Modifier
                        .alpha(0.6f)
                        .padding(top = 10.dp)
                )

                Text(
                    text = "$28,06.57",
                    color = Color.White,
                    fontFamily = poppins,
                    fontSize = 30.sp
                )

                Button(
                    onClick = {  },
                    modifier = Modifier
                        .clip(ShapeDefaults.Large)
                        .border(
                            width = 0.dp,
                            color = Color.Transparent,
                            shape = ShapeDefaults.Large
                        ),
                    colors = ButtonDefaults.buttonColors(containerColor = PrimaryGrey)
                ) {
                    Text(
                        text = "Withdraw",
                        fontSize = 12.sp,
                        modifier = Modifier.align(alignment = CenterVertically)
                    )
                }
            }
            Icon(
                painter = painterResource(id = R.drawable.ic_wallet),
                contentDescription = "",
                tint = Color.White,
                modifier = Modifier
                    .alpha(0.4f)
                    .padding(start = 40.dp)
                    .size(60.dp)
            )
        }
    }

}

@Composable
fun HeaderUI() {

    Row(
        modifier = Modifier
            .padding(horizontal = 20.dp, vertical = 26.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        Column {
            Text(
                text = "Hi Mobiler",
                color = Color.DarkGray,
                modifier = Modifier.alpha(0.6f),
                fontFamily = poppins
            )
            Text(
                text = "Welcome Back",
                color = Color.LightGray,
                fontSize = 20.sp,
                fontFamily = poppins,
                fontWeight = FontWeight.Bold
            )
        }

        Image(
            painter = painterResource(id = R.drawable.user),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(80.dp)
                .border(
                    width = 0.5.dp,
                    color = Color.LightGray,
                    shape = CircleShape
                )
                .clip(CircleShape)
        )
    }
}
