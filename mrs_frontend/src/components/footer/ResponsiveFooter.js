import { MDBContainer, MDBFooter } from 'mdb-react-ui-kit';
import './ResponsiveFooter.css';

export default function ResponsiveFooter() {
	return (
		<MDBFooter className='text-center' color='white' bgColor='dark'>
			<MDBContainer className='p-3  pb-0'>
				{/* <section className='mb-4'>
					<MDBBtn outline color="light" floating className='m-1' href='#!' role='button'>
						<MDBIcon fab icon='facebook-f' />
					</MDBBtn>
					<MDBBtn outline color="light" floating className='m-1' href='#!' role='button'>
						<MDBIcon fab icon='angry' />
					</MDBBtn>
					<MDBBtn outline color="light" floating className='m-1' href='#!' role='button'>
						<MDBIcon fab icon='google' />
					</MDBBtn>
					<MDBBtn outline color="light" floating className='m-1' href='#!' role='button'>
						<MDBIcon fab icon='instagram-5x' />
					</MDBBtn>
					<MDBBtn outline color="light" floating className='m-1' href='#!' role='button'>
						<MDBIcon fab icon='linkedin-in' />
					</MDBBtn>
					<MDBBtn outline color="light" floating className='m-1' href='#!' role='button'>
						<MDBIcon fab icon='github' />
					</MDBBtn>
				</section> */}

				<section className=''>
					<form action='' className='footerForm'>
						<span className='formTag'>Sign up for Updates & Newsletter</span>
						<input className="formEmail" type='email' placeholder='Your e-mail' label='Email address' required />
						<input type='submit' value="Save" />
						{/* <MDBBtn outline color='light' type='submit' className='mb-4'>Subscribe</MDBBtn> */}
					</form>
				</section>

				<section>
					<p>Server on Spring Boot and Mongo DB, and Client on ReactJs</p>
				</section>

				{/* 	<section className=''>
					<MDBRow>
						<MDBCol lg='3' md='6' className='mb-4 mb-md-0'>
							<h5 className='text-uppercase'>Links</h5>
							<ul className='list-unstyled mb-0'>
								<li><a href='#!' className='text-white'>Link 1</a></li>
								<li><a href='#!' className='text-white'>Link 2</a></li>
								<li><a href='#!' className='text-white'>Link 3</a></li>
								<li><a href='#!' className='text-white'>Link 4</a></li>
							</ul>
						</MDBCol>

						<MDBCol lg='3' md='6' className='mb-4 mb-md-0'>
							<h5 className='text-uppercase'>Links</h5>

							<ul className='list-unstyled mb-0'>
								<li>
									<a href='#!' className='text-white'>
										Link 1
									</a>
								</li>
								<li>
									<a href='#!' className='text-white'>
										Link 2
									</a>
								</li>
								<li>
									<a href='#!' className='text-white'>
										Link 3
									</a>
								</li>
								<li>
									<a href='#!' className='text-white'>
										Link 4
									</a>
								</li>
							</ul>
						</MDBCol>

						<MDBCol lg='3' md='6' className='mb-4 mb-md-0'>
							<h5 className='text-uppercase'>Links</h5>

							<ul className='list-unstyled mb-0'>
								<li>
									<a href='#!' className='text-white'>
										Link 1
									</a>
								</li>
								<li>
									<a href='#!' className='text-white'>
										Link 2
									</a>
								</li>
								<li>
									<a href='#!' className='text-white'>
										Link 3
									</a>
								</li>
								<li>
									<a href='#!' className='text-white'>
										Link 4
									</a>
								</li>
							</ul>
						</MDBCol>

						<MDBCol lg='3' md='6' className='mb-4 mb-md-0'>
							<h5 className='text-uppercase'>Links</h5>

							<ul className='list-unstyled mb-0'>
								<li>
									<a href='#!' className='text-white'>
										Link 1
									</a>
								</li>
								<li>
									<a href='#!' className='text-white'>
										Link 2
									</a>
								</li>
								<li>
									<a href='#!' className='text-white'>
										Link 3
									</a>
								</li>
								<li>
									<a href='#!' className='text-white'>
										Link 4
									</a>
								</li>
							</ul>
						</MDBCol>
					</MDBRow>
				</section> */}
			</MDBContainer>

			<div className='text-center p-3 pt-1' style={{ backgroundColor: 'rgba(0, 0, 0, 0.2)' }}>
				©By: <a className='text-white fw-bolder lead ms-2' target="_blank" rel="noreferrer" href='https://ujjwalpandeyjava.github.io/Ujjwal-Portfolio/'>Ujjwal Pandey</a>
			</div>
		</MDBFooter>
	);
}