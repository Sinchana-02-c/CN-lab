BEGIN{
count=0;
}
{
event=$1;
if(event=="d"){
count++;
}
}
END{
printf("\n number of packets dropped is:%d \n",count);
}
